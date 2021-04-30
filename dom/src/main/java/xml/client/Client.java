package xml.client;

import xml.m0.*;
import xml.m2.*;
import xml.m2.finalized.*;

import java.util.Optional;

/** Minimal standalone code to show an evolving client. */
public class Client {
    static class ClientM0<FX, FT, FD> {
        private final Factory<FX,FT,FD> factory;
        final Document<FX,FT,FD> demoDoc;
        public ClientM0(Factory<FX,FT,FD> factory) {
            this.factory = factory;
            this.demoDoc =
                factory.singleRoot(
                    factory.tag("designPattern",
                            factory.tag("name", factory.text("CoCo")),
                            factory.tag("relatedPattern", factory.text("Factory"))
                    )
                );
        }
        public void run() {
            System.out.println("Has CoCo: " + demoDoc.hasElem("CoCo"));
            System.out.println("Has relatedPattern: " + demoDoc.hasElem("relatedPattern"));
            System.out.println("Has Visitor: " + demoDoc.hasElem("Visitor"));
            System.out.println("Has related: " + demoDoc.hasElem("related"));
        }
    }
    static class ClientM2<FX, FT, FD> {
        private final EFactory<FX,FT,FD> factory;
        private final ClientM0<FX, FT, FD> collaborator;
        final XML<FX,FT,FD> schema;
        public ClientM2(EFactory<FX,FT,FD> factory, ClientM0<FX, FT, FD> collaborator) {
            this.factory = factory;
            this.collaborator = collaborator;
            this.schema =
                factory.schema(factory.singleRoot(
                        factory.tag("designPattern",
                                factory.tag("name"),
                                factory.tag("relatedPattern")
                        )
                ));
        }
        public void run() {
            collaborator.run();
            Optional<Tag<FX, FT, FD>> root = collaborator.demoDoc.getRootTag();
            if (root.isEmpty()) { return; }
            Optional<String> isValid = factory.convert(schema).validate(root.get());
            System.out.println("Errors: " + isValid.toString());
        }
    }
    public static void main(String[] args) {
        EFactory<FEXML, FETag, FEDocument> factory = new FEFactory() {};
        ClientM0<FEXML, FETag, FEDocument> client = new ClientM0<>(factory);
        ClientM2<FEXML, FETag, FEDocument> evolved = new ClientM2<>(factory, client);
        evolved.run();
    }
}
