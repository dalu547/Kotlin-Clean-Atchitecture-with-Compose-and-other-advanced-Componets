## Flutter Scaffold Template

## Overview
This is a Flutter project developed as a technical test by **Dalayya Kalla**. The project focuses on **Folder struture, MVVM architecture and Lib integrations**.

## Table of Contents
- [Architecture](#architecture)
- [Folder Structure](#folder-structure)
- [Libraries Used](#What-are-all-included)


## Architecture

The Project is Based on MVVM and Clean-Architecture with consideration of SOLID principles.

![Architecture Diagram](screenshots/clean_architecture.png)

## Folder Structure

We used Featured based folder structure than layer based.

Feature based -  Layers (Data , domain and presentation) insdie features.
Layer based   -  Features inside layers. 

**Data:** The data layer serves as a bridge between the domain layer and the presentation layer, supplying data through implementations of data sources, repositories, and models.

**Domain:** The domain layer encapsulates the core business logic and rules, acting as an intermediary between the data layer and presentation layer to ensure separation of concerns and maintain a clean, business-centric architecture. 

**Presentation**: The presentation layer manages user interfaces and interactions, focusing on the visual representation of data and user experience. It relies on the domain layer for business logic and the data layer for data retrieval, fostering a clear separation of concerns in the application architecture.

![Folder Diagram](screenshots/folder_structure.png)

## What are all included

- **Kotlin**: Core language
- **MVVM** :  UI logic separation (ViewModel, View, Model)
- **Clean Architecture** : Domain, Data, and Presentation layers
- **Coroutines** : For Asynchronous tasks
- **Flows** : For State Management
- **Hilt**: Dependency Injection (To inject ViewModels, Repositories, UseCases, etc.)
- **Retrofit**: For Networking (HTTP client)
- **Moshi** : JSON ↔️ Kotlin data classes.
- **Coil**: Image loading library optimized for Compose
- **Room**: Local Database
- **Compose**: UI
- **Navigation**: For in-app navigation
- **WorkManager** : For background syncing & jobs
- **Timber** : Better logging than Log.d()
 

  






