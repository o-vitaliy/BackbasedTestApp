# Mobile assignment RnD

Application was implemented in Kotlin.
Navigation was done using [https://developer.android.com/guide/navigation]  
For DI was chosen Kodein [https://kodein.org/Kodein-DI/]

For filtering data were implemented to filters *SimpleDataFilter* and *LetterStagedDataFilter*
Benchmarks show such performance (in nanoseconds):
             LetterStagedDataFilter         SimpleDataFilter
Z            247357343                      185717343
Za           10566823                       148370677
Zap          6825260                        147650677
Zapo         195417                         147578542
Zapon        143021                         145578282



