(ns mywebapp.routes
  (:use compojure.core
        mywebapp.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))


(defroutes app-routes
  (GET "/" [] (index-page))
  (GET "/about" [] (about-page))
  (route/resources "/")
  (route/not-found "No page"))


(def app
  (handler/site app-routes))
