(ns mywebapp.views
  (:use [hiccup core page]))

(defonce counter (atom 1))

(defn header []
  [:div.navbar.navbar-inverse.navbar-fixed-top
   [:div.navbar-inner
    [:div.container
     [:a.brand {:href "/"} "Cloudbees Clickstart[" @counter "]"]
     [:div.nav-collapse.collapse
      [:ul.nav
       [:li.active [:a {:href "/"} "Home"]]
       [:li.active [:a {:href "/about"} "About"]]]]]]])

(defn template [& body]
  (html5
   [:head
    [:title "Cloudbees clickstart"]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    (include-css "/css/bootstrap.min.css")]
   [:body {:style "padding-top:60px;"}
    (header)
    [:div.container
     body]]))

(defn index-page []
  (template
   
   [:div {:class "hero-unit"}
    [:h1 "Clojure on Cloudbees"]
    [:p "Welcome to the Clojure Clickstart!"]
    [:p
     [:a {:class "btn btn-primary btn-large"
          :href "http://developer.cloudbees.com/bin/view/Main/"}
      "Get help with Cloudbees."]]]
      
      [:div {:class "well"}
        [:p
          [:h3 "Next steps"]
          [:ul
            [:li (str "Make sure you have an ssh public key setup on" 
                      "<a href=\"https://grandcentral.cloudbees.com/user/ssh_keys\">
                      Cloudbees</a> and then run:")]
            [:li 
              [:code (str 
                      "git clone ssh://git@git.cloudbees.com/"
                      "<script>document.write"
                        "(location.hostname.split(\".\")[1])</script>"
                      "/<script>document.write"
                      "(location.hostname.split(\".\")[0])</script>.git")]]
            [:li "Make your changes and then push to the git repo"]  
            [:li "This will trigger a build and deploy cycle on cloudbees"]]]]))

(defn about-page []
  (template
   [:div {:class "well"}
    [:h1 "About This:"]
    [:p "This Clojure clickstart was developed by members of the "
     [:a {:href "http://www.meetup.com/Austin-Clojure-Meetup/"} "Austin Clojure Meetup"]
     ".  You can find us as "
     [:a {:href "https://github.com/AustinClojure"} "AustinClojure on github"]
     "."]
     [:h1 "About ClickStarts:"]
      "Read about what ClickStarts are "
     [:a {:href "https://developer.cloudbees.com/bin/view/RUN/ClickStart"} "at CloudBees"]

     ]))
