package nl.jobse.freemarker;


	import freemarker.template.*;
	import java.util.*;
	import java.io.*;

	public class Demo {

	    public static void main(String[] args) throws Exception {

	        /* ------------------------------------------------------------------------ */
	        /* You should do this ONLY ONCE in the whole application life-cycle:        */

	        /* Create and adjust the configuration singleton */
	        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
	        cfg.setDirectoryForTemplateLoading(new File("./"));
	        cfg.setDefaultEncoding("UTF-8");
	        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	        cfg.setLogTemplateExceptions(false);
	        cfg.setWrapUncheckedExceptions(true);

	        /* ------------------------------------------------------------------------ */
	        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

	        /* Create a data-model */
	        Map root = new HashMap();
	        root.put("user", "Rob Jobse");
	        Product latest = new Product();
	        latest.setUrl("products/greenmouse.html");
	        latest.setName("green mouse");
	        root.put("latestProduct", latest);

	        /* Get the template (uses cache internally) */
	        Template temp = cfg.getTemplate("greet.ftlh");

	        /* Merge data-model with template */
	        Writer out = new OutputStreamWriter(System.out);
	        temp.process(root, out);
	        // Note: Depending on what `out` is, you may need to call `out.close()`.
	        // This is usually the case for file output, but not for servlet output.
	    }
	}
