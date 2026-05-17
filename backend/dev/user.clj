(ns user
  (:require [integrant.core :as ig]
            [integrant.repl :as ig-repl]
            [integrant.repl.state :as state]
            [shopping-list.core :as core]
            ;; load side-effecting integrant methods
            [shopping-list.server]
            [shopping-list.db]
            [shopping-list.router]))

(ig-repl/set-prep! core/read-config)

(defn go []   (ig-repl/go))
(defn halt [] (ig-repl/halt))
(defn reset [] (ig-repl/reset))
