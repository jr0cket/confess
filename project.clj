(defproject confess "0.1.0"
	:description "Anonymous Confession Web App on Couchbase"
	:url "http://rbin.co"
	:main confess.app
	:dependencies [[org.clojure/clojure "1.4.0"]
					 [cheshire "5.0.1"]
					 [ring/ring-jetty-adapter "1.1.0"]
					 [compojure "1.1.3"]
					 [hiccup "1.0.2"]
					 [apage43/cbdrawer "0.1.0"]])