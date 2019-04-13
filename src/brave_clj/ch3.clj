(ns brave-clj.ch3)

;; Clojure forms
;; ===================================================================

;; !! Impotant thing to know that, everything in clojure is 'finction' !!

;; A clojure form is somthing that evaluats to itself, example numeric 1 is evaluated to 1 similarly string "binay" is evaluated to binay
;; 1 to 2
;; "Binay" to binay
;; ["a" "vector"] to vector data straucture

;; clojure used prefix notations. the great thing of prefix notation is it can take infinite arguments.
(+ 1 2 3)
;; The interesting thing to notic is that , in case of infix we have to repate the operator multiple times.
;; 1 + 2 + 3 ; (+) 3 times where in clojure it's only one time

(def my-full-name 
	(str "Binay" " " "Mishra"))

(println "My full name is " my-full-name)


;; Clojure Control Flow
;; ===================================================================

;; (if boolean-form
;; 	then-form
;;		optional-else-form)

;; Clojure functions always returns a value. the simplest value is nil which equvalent to null
(if true
	(println "TRUE")) ;; no else branch

(if false
	(println "TRUE")
		(println "FALSE")) ;; "FALSE is else branch"


(if true
	"By Zeus's hammer!"
	"By Aquaman's trident!")

(if false
	"By Zeus's hammer!"
	"By Aquaman's trident!")
	
;;(use 'brave-clj.ch3 :reload-all)
(println "Successfully re-loaded all the forms !!")