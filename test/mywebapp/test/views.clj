(ns mywebapp.test.views
  (:use clojure.test
        ring.mock.request  
        mywebapp.routes))

(deftest test-app
  (testing "main app"
    (let [response (app (request :get "/"))]
      (is (= (:status response) 200))))
  
  (testing "not-found route"
    (let [response (app (request :get "/invalid"))]
      (is (= (:status response) 404)))))