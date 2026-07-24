# Terrain Smoothing Algorithm

## Overview

This project is a simple Java program that smooths terrain (elevation data) using **median filtering**. Terrain data is represented as a 2D array, and the program reduces noise such as sudden spikes or irregular values to make the terrain more realistic.

---

## How It Works

* The terrain is stored as a 2D array
* For each cell, nearby values (neighbors) are collected based on a radius `k`
* The values are sorted, and the **median** is chosen
* The original value is replaced with the median

This helps remove extreme values while keeping the overall shape of the terrain.

---

## Technologies Used

* Java
* Arrays and loops

---

## Example

### Input:

```
10  12  15  14
13  99  12  11
14  13  16  15
15  17  14  13
```

### Output:

```
13  13  14  14
13  13  14  15
15  14  14  14
15  15  15  15
```

