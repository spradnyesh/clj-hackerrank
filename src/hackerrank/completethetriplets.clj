(ns hackerrank.completethetriplets)

;;https://www.hackerrank.com/challenges/compare-the-triplets/problem
(defn solve [a0 a1 a2 b0 b1 b2]
  (let [a [a0 a1 a2]
        b [b0 b1 b2]
        f (fn [x y] (reduce + (map #(if (> % %2) 1 0) x y)))]
    [(f a b) (f b a)]))

;; boilerplate already provided by HR
(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def a0A1A2 (clojure.string/split (read-line) #" "))

(def a0 (Integer/parseInt (clojure.string/trim (nth a0A1A2 0))))

(def a1 (Integer/parseInt (clojure.string/trim (nth a0A1A2 1))))

(def a2 (Integer/parseInt (clojure.string/trim (nth a0A1A2 2))))

(def b0B1B2 (clojure.string/split (read-line) #" "))

(def b0 (Integer/parseInt (clojure.string/trim (nth b0B1B2 0))))

(def b1 (Integer/parseInt (clojure.string/trim (nth b0B1B2 1))))

(def b2 (Integer/parseInt (clojure.string/trim (nth b0B1B2 2))))

(def result (solve a0 a1 a2 b0 b1 b2))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)
