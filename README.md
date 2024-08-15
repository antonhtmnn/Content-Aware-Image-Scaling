# Content-Aware-Image-Scaling

This repository contains the implementation of content-aware image resizing (also known as seam carving). The primary goal is to reduce one of the image dimensions while preserving the essential elements of the image. This is achieved by iteratively finding and removing vertical paths (seams) with the least contrast, thereby minimizing distortion of the important content.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)

## Installation

To set up this project locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/antonhtmnn/Content-Aware-Image-Scaling.git
   ```

2. Clone the repository:

   ```bash
   cd Content-Aware-Image-Scaling
   ```

3. Compile the Java files:

   ```bash
   javac ./*.java
   ```

## Usage

You can run the different components of the project by executing the compiled Java classes. For example, to perform content-aware image resizing, you would execute:

```bash
java ContentAwareImageResizing
```

## Features

### 1. Matrix Image Processing

- **MatrixImage.java**: Implements the seam carving algorithm on simple matrices, allowing for testing and debugging. The key methods include calculating contrast between matrix elements and removing vertical paths.

### 2. Shortest Paths in DAGs

- **ShortestPathsTopological.java**: Implements the shortest paths algorithm using topological sorting, specifically tailored for Directed Acyclic Graphs (DAGs). This is used to efficiently find the least contrast path in the content-aware image resizing process.

### 3. Content-Aware Image Resizing

- **ContentAwareImageResizing.java**: The main class that implements content-aware image scaling using seam carving. It finds and removes the vertical path with the lowest contrast in the image, effectively resizing the image without distorting key elements.
