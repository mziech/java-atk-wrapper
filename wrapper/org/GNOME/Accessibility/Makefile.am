JAVA_SRC=$(wildcard $(srcdir)/*.java)
CLASSES=$(patsubst %.java,%.class,$(JAVA_SRC))
BUILD_CLASSES=$(builddir)/AtkConstants.class $(patsubst $(srcdir)%,$(builddir)%,$(CLASSES))

EXTRA_DIST=$(JAVA_SRC) AtkConstants.java.in $(srcdir)/*.java

all-local: $(BUILD_CLASSES)

AtkConstants.java : AtkConstants.java.in
	sed -e "s;\@XPROP\@;${XPROP};g" \
		-e "s;\@VERSION\@;${VERSION};g" \
		-e "s;\@PACKAGE_NAME\@;${PACKAGE_NAME};g" \
		< $< >$@

%.class : %.java
	CLASSPATH=$(top_srcdir)/wrapper $(JAVAC) $(JAVACFLAGS) -d $(top_builddir)/wrapper $<

clean-local:
	$(RM) *.class
	$(RM) AtkConstants.java

