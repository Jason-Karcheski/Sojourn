# Sojourn
Sojourn is a travel planning app for Android.

## Module Architecture
### Feature Modules
Used for defining composables and state. For example a Feature Module that covers the Dashboard would be named as so - `:Feature:Dashboard`.

### Domain Modules
Used for defining internal business logic specific to a particular domain of the app. Usually this is in the form of usecases. A Domain Module that covers Authentication would be named as `:Domain:Authentication`

### Data Modules
Used for defining data code including repositorties and data sources. A Data Module that handles Trip data would be named as `:Data:Trip`.

### Common Modules
Used to share code that is common between modules on the same layer. For instance there will be a `:Common:Feature` module to share code that is used in multiple Feature Modules. Same goes for Domain and Data Modules.
These Common Modules are likely to be broken down into further levels so that the entire `:Common:Feature`, `:Common:Domain` or `:Common:Data` module doesn't have to be imported as one block.
An example would be having something like `:Common:Feature:Composables` and `:Common:Feature:Theme`.
