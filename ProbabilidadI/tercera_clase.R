hist(runif(100,-2,5), xlab = "valores jajsj", col = "hotpink", freq = FALSE, main = "Histograma") # Da un n

Mivolado <- function(p){
  U <- runif(1,0,1)
  resultado <- 0
  if(U < p){
    return(1)
  }else{
    return(0)
  }
}
conteo <- 0

P <- .35

for (i in 1:N) {
  resultado <- Mivolado(P)
  conteo <- conteo + resultado
}
proba = conteo/N
print(proba)

### Camimante aleatorio ###

Caminante <- function(tiempo){
  Direccion <- runif(1,0,1)
  if(Direccion < .5){
    pasitoy <- 0
    arriba_abajo <- runif(1,0,1)
    if(arriba_abajo <.5){
      pasitoy <- -1
    }else{
      pasitoy <- 1
    }
  }
}

A = list(c(1,0), c(-1,0), c(0,1), c(0,-1))

randomA <- function(A){
  U < runif(1,0,1)
  pasito <- c(0,0)
  if(U < 0.25){
    pasito <- A[[1]]
  }else{
    
  }
  
}

