(ns shopping-list.queries
  (:require [next.jdbc :as jdbc]
            [next.jdbc.result-set :as rs]
            [honey.sql :as sql]))

(defn get-lists [db]
  (jdbc/execute! db
                 (sql/format {:select [:id :name :created_at]
                              :form [:shopping_lists]})
                 {:builder-fn rs/as-unqualified-kebab-maps}))

(defn ->list-dto [row]
  {:id (:id row)
   :name (:name row)
   :created-at (str (:created-at row))})

(defn list-all [db]
  (->> (get-lists db)
       (mapv ->list-dto)))
