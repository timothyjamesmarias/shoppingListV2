(ns shopping-list.server
  (:require [integrant.core :as ig]
            [ring.adapter.jetty :as jetty]
            [shopping-list.router :as router]))

(defmethod ig/init-key :server/jetty [_ {:keys [handler port join?]}]
  (println (str "Starting server on port " port))
  (jetty/run-jetty handler {:port port :join? join?}))

(defmethod ig/halt-key! :server/jetty [_ server]
  (.stop server))
