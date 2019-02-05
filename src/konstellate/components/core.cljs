(ns konstellate.components.core
  (:require
    recurrent.drivers.dom
    [clojure.pprint :as pprint]
    [clojure.set :as sets]
    [clojure.string :as string]
    [recurrent.state :as state]
    [recurrent.core :as recurrent :include-macros true]
    [ulmus.signal :as ulmus]))

(def shadow "2px 2px 4px rgba(0,0,0, 0.25)")
(def primary "#FEA7BD")
(def secondary "#09EDC8")

(defn parse-int
  [v]
  (let [as-int (js/parseInt v 10)]
    (if (js/isNaN as-int)
      0
      as-int)))

(recurrent/defcomponent ActionButton
  [props sources]
  {:click-$ ((:recurrent/dom-$ sources) :root "click")
   :recurrent/dom-$ (ulmus/signal-of [:div {:class "action-button"} "+"])})

(recurrent/defcomponent TextInput
  [props sources]
  (let [value-$ (ulmus/map
                  (fn [e] 
                    (.-value (.-target e)))
                  ((:recurrent/dom-$ sources) "input" "keyup"))]
    {:value-$ value-$
     :recurrent/dom-$ (ulmus/map
                        (fn [value]
                          [:div {:class "text-input"}
                           [:label (:label props)]
                           [:input {:type "text" :value value}]])
                        (ulmus/distinct (ulmus/start-with! "" value-$)))}))

