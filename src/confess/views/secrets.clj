(ns confess.views.secrets
	(:use [hiccup.core :only [html h]]
		[hiccup.form :only [form-to label text-area submit-button]])
	(:require [confess.views.layout :as layout]))

(defn confess-form []
	[:section {:id "confess-form" }
	 (form-to [:post "/"]
		[:br]
		(text-area "secret" "I secretly love confess.im ...")
		[:br]
		(submit-button "Confess it!"))])

(defn display-secrets [secrets]
	 [:div {:id "container"}
		 (for [secret secrets]
			 [:div {:class "item"} (:data secret)])])

(defn index [secrets]
	(layout/common "Share Your Secrets | Confess.im"
		[:div {:class "greyBar"}
			[:div {:class "Contain"}
				[:aside {:id "intro"}
					[:h1 "Go ahead," [:br] "Tell us a secret!"]
					[:h3 {:class "anon"} "(It's completely anonymous!)"]]

				(confess-form)]]
				[:br]
				(display-secrets secrets)))
