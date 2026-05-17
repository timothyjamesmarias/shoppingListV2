(ns shopping-list.router
  (:require [integrant.core :as ig]
           [reitit.ring :as ring]
           [ring.middleware.json :refer [wrap-json-response]]
           [ring.util.response :refer [response]]
           [shopping-list.handlers :as handlers]))

(defmethod ig/init-key :server/routes [_ {:keys [db]}]
  (ring/ring-handler
   (ring/router
    [
      ["/" {:get {:handler (handlers/hello db)}}]
      ["/lists" {:get {:handler (handlers/lists db)}}]
     ]
    )
   (ring/routes
    (ring/create-resource-handler {:path "/"})
    (ring/create-default-handler))))
