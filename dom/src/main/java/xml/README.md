# Introduction

The XML case study provides a rich example of a domain that is further refined in 
subsequent evolutions. It shows how to add subdomains, such as Document. You can
also add new data types and operations, including binary and producer operations.

M0 provides the foundation of a domain based on a simplified XML document model. 
Starting with five essential data types: XML provides the general interface for
any XML data type. XML tags are modeled by the Tag data type; inside of Tags
can be free-floating arbitrary strings, as modeled by the Text data type.

Document groups subdomains of things that can be considered to be complete XML
documents. SingleRoot is one example of a Document data type that contains a single
XML tag as its root node.

The first extension, m1, adds a data type for XML schemas. These Schemas are 
considered to consist of an entire XML document. 

The second extension, m2, adds schema validation as an operation. This operation 
is not limited to just entities classified as Schema. All XML data types from
the original domain are extended (i.e., EXML extends XML and so on). Doing so
ensures that future data types added to the original XML domain will also have 
a similar extension here (e.g., DTD schema interpreter or XSD style).

The example includes side effects because of the `addChild` method in the original
XML domain. This is a binary method with side effects.

# Miscellaneous

Full code coverage is provided by test cases in the same fashion as the mathematical
expression domain.

For a demonstration of (non-test) client see class `Client` in `xml.client`.
