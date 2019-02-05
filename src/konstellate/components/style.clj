(ns konstellate.components.style
  (:require
    [garden.core :as garden]
    [garden.def :refer [defkeyframes]]))

(def shadow "2px 2px 4px rgba(0,0,0, 0.25)")
(def primary "#FEA7BD")
(def secondary "#09EDC8")
(def text "#212b35")
(def grey "#dfe3e8")

(def ActionButton
  [:.action-button {:background secondary
                    :bottom "16px"
                    :border-radius "50%"
                    :box-shadow shadow
                    :color "white"
                    :cursor "pointer"
                    :right "32px"
                    :height "64px"
                    :font-size "24px"
                    :line-height "64px"
                    :position "absolute"
                    :text-align "center"
                    :width "64px"}])

(def Button
  [:.button {:border "1px solid white"
             :border-radius "1000px"
             :color "white"
             :cursor "pointer"
             :line-height "40px"
             :min-width "128px"
             :height "40px"
             :padding "0 32px"
             :font-weight "bold"
             :text-align "center"}
   [:&.outline {:color text
                :border (str "1px solid " grey)
                :background "none"}]
   [:&.primary {:background "black"
                :border "1px solid transparent"
                :color "white"}]
   [:&.inverse {:background "white"
                :border (str "1px solid " grey)
                :color text}]])

(def BottomBanner
  [:.bottom-banner {:background "black"
                    :height "72px"
                    :display "flex"
                    :align-items "center"
                    :padding-right "32px"
                    :justify-content "flex-end"}
   [:* {:margin-left "16px"}]])

(def TextInput
  [:.text-input
   [:label {:display "block"
            :font-size "12px"
            :font-weight "normal"
            :margin-bottom "4px"
            :opacity "0.5"}]
   [:input {:border "1px solid lightgrey"
            :border-radius "4px"
            :font-size "16px"
            :height "40px"
            :outline "none"
            :padding "0 16px"
            :width "100%"}]])

(defn styles
  []
  (garden/css 
    ActionButton
    Button
    BottomBanner
    TextInput))

(defn spit-styles!
  []
  (spit "resources/public/css/style.css" (styles)))

