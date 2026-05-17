(ns shopping-list.handlers
  (:require [ring.util.response :refer [response]]
            [shopping-list.queries :as queries]))

(defn hello [db]
  (fn [_request]
    (response {:message "hello"})))

(defn lists [db]
  (fn [_request]
    {:status 200
     :body (queries/list-all db)}))
