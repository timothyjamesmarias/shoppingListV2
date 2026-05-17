(ns shopping-list.core
  (:require [integrant.core :as ig]
            [aero.core :as aero]
            [clojure.java.io :as io]
            [shopping-list.server]
            [shopping-list.db]
            [shopping-list.router]))

(defmethod aero/reader 'ig/ref [_ _ value]
  (ig/ref value))

(defn read-config []
  (-> (io/resource "system.edn")
      (aero/read-config)
      ig/prep))

(defn -main [& _]
  (let [config (read-config)]
    (ig/init config)))
