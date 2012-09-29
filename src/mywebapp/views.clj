(ns mywebapp.views
  (:use [hiccup core page]))

(defn index-page []
  (html5
   [:head
    [:title "Cloudbees clickstart"]
    (include-css "/css/style.css")]
   [:body
    [:h1 "CLOUDBEES!"]
    [:p "Using <b>ring</b>/<b>compojure</b>/<b>hiccup</b>"]
    ]))