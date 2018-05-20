(ns hackerrank.between-two-sets
  (:require [clojure.spec :as s]
            [clojure.spec.gen :as gen]))

;; https://www.hackerrank.com/challenges/between-two-sets/problem

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; spec definitions
(s/def ::int-arr (s/coll-of (s/and int? #(or (zero? %) (pos? %)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; helper functions
(defn set-intersect
  "write our own implementation of `clojure.set/intersection`
  because hackerrank does not allow its use"
  [left right]
  {:pre [(s/valid? ::int-arr left) (s/valid? ::int-arr right)]
   :post [(s/valid? ::int-arr %)]}
  (for [l left
        r right
        :when (= l r)]
    l))

(defn all-zeros?
  "is every element of the `arr` a `zero`?"
  [arr]
  {:pre [(s/valid? ::int-arr arr)]
   :post [(s/valid? boolean? %)]}
  (every? zero? arr))

(defn left-helper
  "returns a true IFF every element of `arr` divides `x` completely"
  [arr x]
  {:pre [(s/valid? ::int-arr arr) (s/valid? int? x)]
   :post [(s/valid? boolean? %)]}
  (all-zeros? (mapv #(mod x %) arr)))

(defn right-helper
  "returns a true IFF every element of `arr` is divisible by `x` completely"
  [arr x]
  {:pre [(s/valid? ::int-arr arr) (s/valid? int? x)]
   :post [(s/valid? boolean? %)]}
  (all-zeros? (mapv #(mod % x) arr)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; main function
(defn getTotalX
  "find number of elements such that
  1. all numbers in first array divide all of the resultant numbers
  2. all of the resultant numbers divide all numbers in the second array"
  [arr1 arr2]
  {:pre [(s/valid? ::int-arr arr1) (s/valid? ::int-arr arr2)
         #_(s/valid? (fn [[x y]] (and (<= (apply max x) (apply min y))))
                   [arr1 arr2])]
   :post [(s/valid? int? %)]}
  ;; optimization inspired by the commented s/valid? above
  (if (> (apply max arr1) (apply min arr2))
    0
    (let [left (filter #(left-helper arr1 %)
                       (range (apply max arr1)
                              (inc (apply min arr2))))
          right (filter #(right-helper arr2 %)
                        left)]
      (count (set-intersect left right)))))
