(ns learning-clojure.core)

(defn applyDiscount?
  [value]
  (if (> value 100)
    true
    false))

(defn discountedValue
  [apply? value]
  (if (apply? value)
    (let [discount (/ 10 100)
          discountCalc (* value discount)]
      (- value discountCalc))
    value))

(println (discountedValue applyDiscount? 300))

