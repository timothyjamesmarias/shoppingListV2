(ns shopping-list.db
  (:require [integrant.core :as ig]
            [next.jdbc :as jdbc]
            [migratus.core :as migratus]))

(defmethod ig/init-key :db/postgres [_ {:keys [jdbc-url]}]
  (let [ds (jdbc/get-datasource {:jdbcUrl jdbc-url})]
    (println "Database connection established")
    ds))

(defmethod ig/init-key :db/migratus [_ config]
  (println "Running migrations...")
  (migratus/migrate config)
  config)
