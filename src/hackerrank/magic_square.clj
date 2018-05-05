(ns hackerrank.magic-square)

;; there is exactly 1 3x3 magic square
;; counting reflections + rotations, there are 8
;; these are defined below
(def all-magic-3-squares [[[2 7 6] [9 5 1] [4 3 8]]
                          [[6 7 2] [1 5 9] [8 3 4]]
                          [[2 9 4] [7 5 3] [6 1 8]]
                          [[4 9 2] [3 5 7] [8 1 6]]
                          [[8 3 4] [1 5 9] [6 7 2]]
                          [[4 3 8] [9 5 1] [2 7 6]]
                          [[6 1 8] [7 5 3] [2 9 4]]
                          [[8 1 6] [3 5 7] [4 9 2]]])

;; given the input i have to find the highest overlap,
;; and then change the difference

(defn get-element [arr i j]
  (nth (nth arr i) j))

(defn closest-magic-square-diff [input]
  (->> all-magic-3-squares
       (map-indexed (fn [idx magic-square]
                      [idx (reduce +
                                   (for [i (range 3)
                                         j (range 3)]
                                     (Math/abs (- (get-element magic-square i j)
                                                  (get-element input i j)))))]))
       (sort-by second)
       first
       second))
