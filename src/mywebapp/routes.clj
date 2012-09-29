(ns mywebapp.routes
  (:use compojure.core
        mywebapp.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))


(defroutes app-routes
  (GET "/" [] (index-page))
  (route/resources "/")
  (route/not-found "DENIED"))


(def app
  (handler/site app-routes))
