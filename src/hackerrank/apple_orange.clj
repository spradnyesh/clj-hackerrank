(ns hackerrank.apple-orange)

;; https://www.hackerrank.com/challenges/apple-and-orange/problem

(defn countApplesAndOranges [s t a b apples oranges]
  (let [num-apples (count (filter #(<= s (+ a %) t) apples))
        num-oranges (count (filter #(<= s (+ b %) t) oranges))]
    [num-apples num-oranges]))

;; (def st (clojure.string/split (read-line) #" "))
;; (def s (Integer/parseInt (clojure.string/trim (nth st 0))))
;; (def t (Integer/parseInt (clojure.string/trim (nth st 1))))
;; (def ab (clojure.string/split (read-line) #" "))
;; (def a (Integer/parseInt (clojure.string/trim (nth ab 0))))
;; (def b (Integer/parseInt (clojure.string/trim (nth ab 1))))
;; (def mn (clojure.string/split (read-line) #" "))
;; (def m (Integer/parseInt (clojure.string/trim (nth mn 0))))
;; (def n (Integer/parseInt (clojure.string/trim (nth mn 1))))
;; (def apple (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))
;; (def orange (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))
;; (def result (countApplesAndOranges s t a b apple orange))
;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (spit fptr (clojure.string/join "\n" result) :append true)
;; (spit fptr "\n" :append true)
