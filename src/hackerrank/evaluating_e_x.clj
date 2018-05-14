(ns hackerrank.evaluating-e-x)

;; https://www.hackerrank.com/challenges/eval-ex/problem

(defn fact [n] (reduce * (range 1 (inc n))))
(defn e [x] (reduce + (map #(/ (Math/pow x %) (fact %)) (range 10))))
(fn evaluating-e-x [lst] (mapv e lst))
