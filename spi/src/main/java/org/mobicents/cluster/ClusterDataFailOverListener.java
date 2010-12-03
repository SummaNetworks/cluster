/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.cluster;

/**
 * 
 * This interface defines callback methods which will be called when the local
 * cluster node looses or wins ownership on a certain cluster data
 * .
 * 
 * @author <a href="mailto:baranowb@gmail.com">Bartosz Baranowski </a>
 * @author martins
 * 
 */
public interface ClusterDataFailOverListener {

	/**
	 * Retrieves the cluster data key, which the listener is bound. The listener
	 * will be invoked to handle failover of any cluster data, which is
	 * bound to the same listener key.
	 * 
	 * @return
	 */
	public ClusterDataKey getListenerKey();
	
	/**
	 * Retrieves the listener's local elector, used to elect the node which does
	 * failover of specific data.
	 * 
	 * @return
	 */
	public LocalFailoverElector getLocalElector();
	
	/**
	 * Retrieves the priority of the listener.
	 * @return
	 */
	public byte getPriority();

	/**
	 * Indicates that it will do fail over the cluster node with the specified {@link ClusterNodeAddress}.
	 * @param address
	 */
	public void failOverClusterMember(ClusterNodeAddress address);
	
	/**
	 * Notifies the local client that it now owns the specified {@link ClusterData}. 
	 * @param clusterData
	 */
	public void wonOwnership(ClusterData clusterData);

	/**
	 * Notifies the local client that it lost ownership of the specified {@link ClusterData}.
	 * @param clusterData
	 */
	public void lostOwnership(ClusterData clusterData);
}
