/* This is free and unencumbered software released into the public domain. */

package com.dydra;

import com.dydra.annotation.*;
import com.dydra.jena.DydraQueryExecutionFactory;
import com.hp.hpl.jena.query.QueryExecution;

/**
 * Represents a Dydra.com RDF repository.
 *
 * @see http://docs.dydra.com/sdk/java
 */
public class Repository extends Resource {
  /**
   * The repository name.
   */
  public String name;

  /**
   * Constructs...
   *
   * @param name    a valid repository name
   */
  public Repository(@NotNull final String name) {
    super(name);
    this.name = name;
  }

  /**
   * Constructs...
   *
   * @param name    a valid repository name
   * @param session
   */
  public Repository(@NotNull final String name, @NotNull final Session session) {
    super(name, session);
    this.name = name;
  }

  /**
   * Returns ...
   *
   * @return the repository owner
   */
  @NotNull
  public Account getAccount() {
    throw new UnsupportedOperationException("not implemented");
  }

  /**
   * Returns the number of RDF statements in this repository.
   *
   * @return a positive integer
   */
  public long getCount() {
    return 0; // TODO: call the dydra.repository.count RPC method
  }

  /**
   * Deletes all data in this repository.
   *
   * @return a pending operation
   */
  @NotNull
  public Operation clear() {
    // TODO: call the dydra.repository.clear RPC method
    throw new UnsupportedOperationException("not implemented");
  }

  /**
   * Imports data from the given URL into this repository.
   *
   * @param  url a valid URL string
   * @return a pending operation
   * @throws NullPointerException if <code>url</code> is null
   */
  @NotNull
  public Operation importFromURL(@NotNull final String url) {
    if (url == null)
      throw new NullPointerException("url cannot be null");

    // TODO: call the dydra.repository.import RPC method
    throw new UnsupportedOperationException("not implemented");
  }

  /**
   * Prepares to execute the given SPARQL query on this repository.
   *
   * Note: this is a Jena-specific method.
   *
   * @param  queryString
   *   the SPARQL query string, e.g. "SELECT * WHERE {?s ?p ?o} LIMIT 10"
   */
  @NotNull
  public QueryExecution prepareQueryExecution(@NotNull final String queryString) {
    if (queryString == null)
      throw new NullPointerException("queryString cannot be null");

    return DydraQueryExecutionFactory.prepare(queryString, this);
  }
}
