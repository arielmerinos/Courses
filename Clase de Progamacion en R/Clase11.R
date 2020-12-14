### CONTINUACION DE GGPLOT2
library(ggplot2)
library(tibble)
library(magrittr)
library(dplyr)
library(gganimate)
library(av)
library(gifski)
library(tidyverse)
library(gapminder)

carros <- mtcars

carros <- rownames_to_column(carros, "Model") %>% 
  transform(cyl = as.factor(.$cyl))

qplot(mpg, wt, data = carros, colour = cyl, shape = cyl)




set.seed(1234)
wdata <- data.frame(sex = factor(rep(c("F", "M"), each = 200)),
                    weight = c(rnorm(200, 55), rnorm(200, 58)))
head(wdata)

# BoxPlot
qplot(x = sex, y = weight, data = wdata, geom = "boxplot", fill = sex)

# Violin plot
qplot(sex, weight, data = wdata, geom = "violin")

# Dot plot
qplot(sex, weight, data = wdata, geom = "dotplot",
      stackdir = "center", binaxis = "y", dotsize = 0.5)

# Histogram  plot
# Change histogram fill color by group (sex)
qplot(weight, data = wdata, geom = "histogram",
      fill = sex)

# Density plot
# Change density plot line color by group (sex)
# change line type
qplot(weight, data = wdata, geom = "density",
      color = sex, linetype = sex)


##### AHORA SI GGPLOT2!!
# Basic scatter plot
ggplot(data = carros, aes(x = wt, y = mpg)) + 
  geom_point()


# Change the point size, and shape
ggplot(carros, aes(x = wt, y = mpg)) +
  geom_point(size = 2, shape = 23)

## Lo mismo que arriba pero me gusta mas porque no arroja warning
ggplot(carros, aes_string(x = "wt", y = "mpg")) +
  geom_point(size = 2, shape = 23)


# Use geometry function
ggplot(wdata, aes(x = weight)) + geom_density()

# OR use stat function
ggplot(wdata, aes(x = weight)) + stat_density()


# Mas graficos importantes

a <- ggplot(wdata, aes_string(x = "weight"))

# geom_area()
# geom_density()
# geom_dotplot()
# geom_freqpoly()
# geom_histogram()
# stat_ecdf() 
# stat_qq() 

a + geom_density()
a + geom_dotplot()
a + geom_histogram()
a + stat_ecdf()


a + geom_area(aes(y = ..density.., fill = sex), stat ="bin", color = "purple")


a + geom_dotplot(aes(fill = sex)) +
  scale_fill_manual(values = c("#999999", "#E69F00"))

## Cuantil - Cuantil
ggplot(mtcars, aes(sample = mpg)) + stat_qq()


### GGANIMATE!

datos <- gapminder
head(datos)

grafico <- datos %>%
  ggplot() + 
  geom_point(aes(x = gdpPercap, y = lifeExp, col = continent, size = pop), alpha = 0.8) + theme_minimal() + 
  theme(legend.position = "bottom") + guides(size = "none") + 
  labs(x = "PIB per Capita" ,y = "Esperanza de Vida",  col = "") 

grafico

grafico +
  transition_time(year)

ggplot(mtcars, aes(factor(cyl), mpg)) +
  geom_boxplot() +
  # Aqui viene gganimate
  transition_states(
    gear,
    transition_length = 2,
    state_length = 1
  ) +
  enter_fade() +
  exit_shrink() +
  ease_aes('sine-in-out')


ggplot(gapminder, aes(gdpPercap, lifeExp, size = pop, colour = country)) +
  geom_point(alpha = 0.7, show.legend = FALSE) +
  scale_colour_manual(values = country_colors) +
  scale_size(range = c(2, 12)) +
  scale_x_log10() +
  facet_wrap(~continent) +
  labs(title = 'Year: {frame_time}', x = 'GDP per capita', y = 'life expectancy') +
  transition_time(year) +
  ease_aes('linear')


p <- ggplot(
  gapminder, 
  aes(x = gdpPercap, y=lifeExp, size = pop, colour = country)
) +
  geom_point(show.legend = FALSE, alpha = 0.7) +
  scale_color_viridis_d() +
  scale_size(range = c(2, 12)) +
  scale_x_log10() +
  labs(x = "GDP per capita", y = "Life expectancy") 
p


p + transition_time(year) +
  labs(title = "Year: {frame_time}")


p + transition_time(year) +
  labs(title = "Year: {frame_time}") +
  shadow_wake(wake_length = 0.1, alpha = FALSE)


LETTERS <- c("A", "B", "C", "D")
letters <- c("a", "b", "c", "d")

abcdario <- function(){
  cat(paste(letters, LETTERS, collapse = "", sep = "\n"))
}

abcdario()
