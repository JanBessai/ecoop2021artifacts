# Introduction

The straight-forward object-oriented implementation would simplify modify in place with
each successive evolution. This is not a valid EP solution because it constantly modifies
existing code with each successive evolution.

# EP Violations

Modifies code.

# Miscellaneous

For this reason, there is no record of these intermediate structures. When the final
evolution (m7i2) occurs, numerous simplifications are made possible:

  * Power from i2 is used to replace the inefficient PowBy from m7

  Here is implementation of PowBy from Add, which simplfy evaluated the
  expression into a literal on which the powby operation was invoked.

        public Exp powby(Exp other) {
            return new Lit(this.eval()).powby(other);
        }

  This can now be replaced with:

        public Exp powby(Exp other) { return new Power(this, other); }

  Similarly, the Divd data type had the following code which distributed the
  powby operation to the numerator and denomiator.

        public Exp powby(Exp other) {
            return new oo.ep.Divd(this.left.powby(other), this.right.powby(other));
        }

  This is also simplified to become:

        public Exp powby(Exp other) { return new Power(this, other); }

  Similar changes occur with the other data types

  * The Mult data type from m3 is combined with the MultBy from i1

   Here is the implementation for multby in Power once i2 was evolved:

        public Exp multby(Exp other) {
            double base = left.eval();
            double addedExp = Math.log(other.eval())/Math.log(base);
            return new oo.ep.Power(this.left, new Add(this.right, new Lit(addedExp)));
        }

   This can now be replaced with:

        public Exp multby(Exp other) { return new Mult(this, other); }
