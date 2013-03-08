(ns confess.models.base
    (:require [clojure.string :as str]
              [cbdrawer.client :as cb]
              [cbdrawer.view :as cbviews]
              [cheshire.core :as json])
    (:import (java.net URI)))

(def confess-design-doc
  {:views
   {:all-secrets
    {:map "function(doc, meta) { if(doc.kind && doc.kind === 'secret') { emit(meta.id); } }"}}})

(defn ensure-views-installed [fact]
    (cbviews/install-ddoc (cb/capi-bases fact) "confess" (json/generate-string confess-design-doc)))

(defn factory
    "Create a Couchbase connection factory, which will be used to create
     database clients and access cluster configuration to query views. Will
     also make sure our design document is installed in the server."
    [] (doto (cb/factory "confess" "" "http://127.0.0.1:8091")
           ensure-views-installed))

(defn db []
    (cb/client (factory)))
