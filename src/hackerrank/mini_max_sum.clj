(ns hackerrank.mini-max-sum)

;; https://www.hackerrank.com/challenges/mini-max-sum/problem

(defn miniMaxSum [arr]
  (let [tmp (mapv (fn [i]
                    (reduce + (concat (take i arr) (drop (inc i) arr))))
                  (range (count arr)))]
    [(apply min tmp) (apply max tmp)]))

;; (def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))
;; (def result (miniMaxSum arr))
;; (def fptr (get (System/getenv) "OUTPUT_PATH"))
;; (spit fptr (clojure.string/join " " result) :append true)
