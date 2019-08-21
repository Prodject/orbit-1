/*
 Copyright (C) 2015 - 2019 Electronic Arts Inc.  All rights reserved.
 This file is part of the Orbit Project <https://www.orbit.cloud>.
 See license in LICENSE.
 */

package orbit.server.routing

import orbit.server.NodeId

data class Route(val path: List<NodeId> = emptyList()) {
    fun push(nodeId: NodeId): Route {
        return Route(listOf(nodeId).plus(this.path))
    }

    fun pop(): PopResult {
        return PopResult(Route(this.path.drop(1)), this.path.last())
    }

    data class PopResult(val route: Route, val nodeId: NodeId) {
    }
}
