(ns confess.views.layout
	(:use [hiccup.page :only [html5 include-css include-js]]))

(defn common [title & body]
	(html5
	 [:head
		[:meta {:charset "utf-8"}]
		[:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
		[:title title]
		(include-css "/css/creator.css")]

	 [:body
		[:section {:id "header"}
			[:div {:class "topBar"} 
				[:div {:class "Contain"}
					[:a {:href "/"}
						[:img {:src "/images/logo.png" :alt "Confess.im"}]]]]]

		[:div {:id "main"} body]

		[:footer{:id "footer"}
			[:p "&copy; Robin J - 2013. "]]

		(include-js "http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js")
		(include-js "/js/jquery.infinitescroll.min.js")
		(include-js "/js/jquery.masonry.min.js")
		(include-js "/js/creator.js")
		]))

(defn four-oh-four []
	(common "Page Not Found"
					[:div {:id "four-oh-four"}
					 "The page you requested could not be found!"]))