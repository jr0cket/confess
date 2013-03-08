(ns confess.models.secret
  (:import java.util.UUID)
  (:require [confess.models.base :refer [factory db]]
            [cbdrawer.client :as cb]
            [cbdrawer.transcoders :refer [json-transcoder]]
            [cbdrawer.view :as cbviews]))


(defn all []
  (let [all-secrets-view (cbviews/view-url (cb/capi-bases (factory))
                                           "confess" "all-secrets")]
    (for [secret (cbviews/view-seq all-secrets-view {:stale false
                                                     :include_docs true})]
      (-> secret :doc :json))))

(defn create [params]
  (let [conn (db)]
    (cb/with-transcoder json-transcoder
      (cb/add! conn (str (UUID/randomUUID)) {:kind "secret" :data params}))))
