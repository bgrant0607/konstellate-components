(ns konstellate.components.style
  (:require
    [garden.core :as garden]
    [garden.def :refer [defkeyframes]]))

(def shadow "2px 2px 4px rgba(0,0,0, 0.25)")
(def primary "#FEA7BD")
(def secondary "#09EDC8")
(def text "#212b35")
(def grey "#dfe3e8")

(defkeyframes ModalFadeIn
  [:from {:opacity 0}]
  [:to {:opacity 1}])

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
   [:&.primary {:background "#00a2ff"
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

(def Select
  [:.select {}
   [:label {:color "#212b35"
            :display "block"
            :font-size "12px"
            :font-weight "bold"
            :letter-spacing "2px"
            :margin-bottom "4px"
            :text-transform "uppercase"}]
    [:select {:appearance "none"
              :background "white"
              :border "1px solid lightgrey"
              :border-radius "4px"
              :font-size "16px"
              :padding "0 16px"
              :height "56px"
              :width "100%"
              :outline "none"
              :user-select "none"
              :-webkit-appearance "none"}]])

(def Modal
  [:.modal-underlay
   {:position "absolute"
    :background "rgba(23, 13, 15, 0.8)"
    :left 0
    :top 0
    :bottom 0
    :right 0
    :z-index 50}
   [:.modal 
    {:animation "ModalFadeIn 500ms ease"
     :background "white"
     :border-radius "4px"
     :box-shadow "shadow"
     :position "absolute"
     :left "50%"
     :transform "translateX(-50%)"
     :top "48px"
     :z-index 100}
    [:.close {:border "2px solid black"
              :border-radius "50%"
              :cursor "pointer"
              :font-size "18px"
              :width "32px"
              :height "32px"
              :position "absolute"
              :right "24px"
              :text-align "center"
              :line-height "26px"
              :top "24px"}]]])

(def SelectionModal
  [:.selection-modal
   [:input {}]])

(defn styles
  []
  (garden/css 
    ActionButton
    Button
    BottomBanner
    ModalFadeIn
    TextInput))

(defn spit-styles!
  []
  (spit "resources/public/css/style.css" (styles)))

