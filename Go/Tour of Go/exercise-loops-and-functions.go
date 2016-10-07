package main

import (
	"fmt"
	"math"
)

func Sqrt(x float64) float64 {
	
	z := x
	res := float64(0)
	
	for {
		z := z - ((math.Pow(z,2)-x)/(2*z))
		
		if math.Abs(res-z) < 1e-15 {
			break
		}
		
		res = z
	}
	
	return res
}

func main() {
	fmt.Println(Sqrt(2))
}
