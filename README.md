# Sojourn
Sojourn is a travel planning app for Android.

## Module Architecture
### Feature Modules
Used for defining composables and state. For example a Feature Module that covers the Dashboard would be named as so - `:feature:dashboard`.

### Data Modules
Used for defining data code including repositories, data models and data sources. A Data Module that handles Trip data would be named as `:data:trip`.

### Common Modules
Used to share code that is common between modules on the same layer. For instance there will be a `:common:feature` module to share code that is used in multiple Feature Modules. Same goes Data Modules.
These Common Modules are likely to be broken down into further levels so that the entire `:common:feature` or `:common:data` module doesn't have to be imported as one block.
An example would be having something like `:common:feature:composables` and `:common:feature:theme`.
