(ns hackerrank.sequence-full-of-colors)

;; https://www.hackerrank.com/challenges/sequence-full-of-colors/problem

;; terminated due to timeout
;; i should not continue if false
(defn sequence-full-of-colors-0 [s]
  (let [ab (fn [s]
             (let [r (count (filter #(= \R %) s))
                   g (count (filter #(= \G %) s))
                   y (count (filter #(= \Y %) s))
                   b (count (filter #(= \B %) s))]
               (and (= r g)
                    (= y b))))
        cd (fn [i s]
            (let [prefix (take i s)
                  r (count (filter #(= \R %) prefix))
                  g (count (filter #(= \G %) prefix))
                  y (count (filter #(= \Y %) prefix))
                  b (count (filter #(= \B %) prefix))]
              (and (<= (Math/abs (- r g)) 1)
                   (<= (Math/abs (- y b)) 1))))
        f (fn [s]
            (and (ab s)
                 (every? true? (mapv #(cd % s) (range 1 (inc (count s)))))))]
    (f s)))

#_(let [n (Integer/parseInt (read-line))]
  (dotimes [_ n]
    (println (if (sequence-full-of-colors (read-line))
               "True"
               "False"))))
