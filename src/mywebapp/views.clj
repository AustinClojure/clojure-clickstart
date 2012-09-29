(ns mywebapp.views
  (:use [hiccup core page]))

(defn template [& body]
  (html5
   [:head
    [:title "Cloudbees clickstart"]
    (include-css "/css/style.css")]
   [:body
    [:h1 "CLOUDBEES!"]
    [:div#content
     body]]))

(defn index-page []
  (template
   [:h2 "Index"]
   [:p "Using " [:b "ring"] "/" [:b "compojure"] "/" [:b "hiccup"]]
   [:div [:a {:href "/second-page"} "Second Page"]]))

(defn second-page []
  (template
   [:h2 "Page Two"]
   [:div [:a {:href "/"} "Back to the index"]]))
