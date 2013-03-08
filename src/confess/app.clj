(ns confess.app
    (:use [compojure.core :only (defroutes)])
    (:require [compojure.route :as route]
              [compojure.handler :as handler]
              [ring.adapter.jetty :as ring]
              [confess.controllers.secrets]
              [confess.views.layout :as layout]))

(defroutes routes
    confess.controller.secrets/routes
    (route/resources "/")
    (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
    (ring/run-jetty (var application) {:port (or port 8080) :join? false}))		

(defn -main []
    (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
        (start port)))