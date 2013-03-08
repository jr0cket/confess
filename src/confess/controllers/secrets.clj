(ns confess.controller.secrets
    (:use [compojure.core :only [defroutes GET POST]])
    (:require [clojure.string :as str]
              [ring.util.response :as ring]
              [confess.views.secrets :as view]
              [confess.models.secret :as model]))

(defn index []
    (println "Index!")
    (view/index (model/all)))

(defn create [params]
    (let [secret (:secret params)]
        (when-not (str/blank? secret)
            (model/create secret)))
    (ring/redirect "/"))

(defroutes routes
    (GET "/" [] (index))
    (POST "/" {params :params} (create params)))
