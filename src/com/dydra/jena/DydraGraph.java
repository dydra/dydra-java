/* This is free and unencumbered software released into the public domain. */

package com.dydra.jena;

import com.dydra.Repository;
import com.dydra.annotation.*;
import com.hp.hpl.jena.graph.BulkUpdateHandler;
import com.hp.hpl.jena.graph.Capabilities;
import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.GraphStatisticsHandler;
import com.hp.hpl.jena.graph.TransactionHandler;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.graph.TripleMatch;
import com.hp.hpl.jena.graph.impl.GraphBase;
import com.hp.hpl.jena.graph.query.QueryHandler;
import com.hp.hpl.jena.shared.PrefixMapping;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.NullIterator;

/**
 * @see http://docs.dydra.com/sdk/java/jena
 * @see http://openjena.org/javadoc/com/hp/hpl/jena/graph/Graph.html
 */
public class DydraGraph extends GraphBase implements Graph {
  protected final Repository repository;
  protected final String uri;

  /**
   * @param  repository
   * @throws NullPointerException if <code>repository</code> is null
   */
  public DydraGraph(@NotNull final Repository repository) {
    this(repository, null);
  }

  /**
   * @param  repository
   * @param  uri
   * @throws NullPointerException if <code>repository</code> is null
   */
  public DydraGraph(@NotNull final Repository repository,
                    @Nullable final String uri) {
    if (repository == null)
      throw new NullPointerException("repository cannot be null");

    this.repository = repository;
    this.uri        = uri;
  }

  /**
   * @return the query handler instance for this graph
   */
  @Override @NotNull
  public QueryHandler queryHandler() {
    if (this.queryHandler == null) {
      this.queryHandler = new DydraQueryHandler(this);
    }
    return this.queryHandler;
  }

  /**
   * @return the graph statistics handler instance for this graph
   */
  @Override @NotNull
  public GraphStatisticsHandler getStatisticsHandler() {
    if (this.statisticsHandler == null) {
      this.statisticsHandler = new DydraGraphStatisticsHandler(this);
    }
    return this.statisticsHandler;
  }

  /**
   * @return a new transaction handler instance for this graph
   */
  @Override @NotNull
  public TransactionHandler getTransactionHandler() {
    return new DydraTransactionHandler(this);
  }

  /**
   * @return the bulk update handler instance for this graph
   */
  @Override @NotNull
  public BulkUpdateHandler getBulkUpdateHandler() {
    if (this.bulkHandler == null) {
      this.bulkHandler = new DydraBulkUpdateHandler(this);
    }
    return this.bulkHandler;
  }

  /**
   * @return the capabilities instance for this graph
   */
  @Override @NotNull
  public Capabilities getCapabilities() {
    if (this.capabilities == null) {
      this.capabilities = new DydraCapabilities();
    }
    return this.capabilities;
  }

  /**
   * @return the prefix mappings instance for this graph
   */
  @Override @NotNull
  public PrefixMapping getPrefixMapping() {
    if (this.pm == null) {
      this.pm = new DydraPrefixMapping(this);
    }
    return this.pm;
  }

  /**
   * @param  triple
   * @throws NullPointerException if <code>triple</code> is null
   */
  @Override
  public void performAdd(@NotNull final Triple triple) {
    if (triple == null)
      throw new NullPointerException("triple cannot be null");

    throw new UnsupportedOperationException("not implemented"); // TODO
  }

  /**
   * @param  triple
   * @throws NullPointerException if <code>triple</code> is null
   */
  @Override
  public void performDelete(@NotNull final Triple triple) {
    if (triple == null)
      throw new NullPointerException("triple cannot be null");

    throw new UnsupportedOperationException("not implemented"); // TODO
  }

  /**
   * @return <code>true</code> if this graph is empty
   */
  @Override
  public boolean isEmpty() {
    return this.graphBaseSize() == 0; // TODO: perform an ASK query
  }

  /**
   * Returns the number of triples in this graph.
   *
   * @return zero or a positive integer
   */
  @Override
  protected int graphBaseSize() {
    return super.graphBaseSize(); // TODO: perform a SELECT COUNT() query
  }

  /**
   * Finds triples in this graph that match the given triple pattern.
   *
   * @param  pattern the triple pattern to match for
   * @return an iterator yielding matching triples
   * @throws NullPointerException if <code>pattern</code> is null
   */
  @Override @NotNull
  protected ExtendedIterator<Triple> graphBaseFind(@NotNull final TripleMatch pattern) {
    if (pattern == null)
      throw new NullPointerException("pattern cannot be null");

    return new NullIterator<Triple>(); // TODO: perform a CONSTRUCT query
  }
}
