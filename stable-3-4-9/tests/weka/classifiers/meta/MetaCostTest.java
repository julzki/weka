/*
 * Copyright 2002 University of Waikato
 */

package weka.classifiers.meta;

import weka.classifiers.*;
import weka.core.Instances;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.InputStreamReader;

/**
 * Tests MetaCost. Run from the command line with:<p>
 * java weka.classifiers.meta.MetaCostTest
 *
 * @author <a href="mailto:eibe@cs.waikato.ac.nz">Eibe Frank</a>
 * @version $Revision: 1.2.2.2 $
 */
public class MetaCostTest extends AbstractClassifierTest {

  public MetaCostTest(String name) { 
    super(name);  
  }

  /**
   * Called by JUnit before each test method. This implementation creates
   * the default classifier to test and loads a test set of Instances.
   *
   * @exception Exception if an error occurs reading the example instances.
   */
  protected void setUp() throws Exception {
    super.setUp();

    // can handle only as much classes as there are in the CostMatrix!
    m_NClasses = ((MetaCost) getClassifier()).getCostMatrix().numRows();
  }

  /** Creates a default MetaCost */
  public Classifier getClassifier() {

    MetaCost cl = new MetaCost();
    
    // load costmatrix
    try {
      cl.setCostMatrix(
          new CostMatrix(
            new InputStreamReader(ClassLoader.getSystemResourceAsStream(
                  "weka/classifiers/data/ClassifierTest.cost"))));
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return cl;
  }

  public static Test suite() {
    return new TestSuite(MetaCostTest.class);
  }

  public static void main(String[] args){
    junit.textui.TestRunner.run(suite());
  }

}
