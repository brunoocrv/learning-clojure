(ns learning-clojure.prices)

(def prices [30, 700, 1000])

(defn applyDiscount?
  [value]
  (if (> value 100)
    true
    false))

(defn discountedValue
  [value]
  (if (applyDiscount? value)
    (let [discount (/ 10 100)
          discountCalc (* value discount)]
      (- value discountCalc))
    value))

(println (map discountedValue prices))
(println (filter applyDiscount? prices))
(println (reduce + 0 prices))                               ; 0 -> 1730