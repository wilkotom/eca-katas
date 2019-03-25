def reachable_destination(origin, destination):
    valid_routes = {
        "ALC": ["CDG", "LHR", "LGW", "JFK"],  # Planes depart ALC for CDG, LHR and LGW airports
        "LHR": [],
        "LGW": ["ALC", "LED", "CDG"],
        "LED": ["MAN", "ALC"],
        "MAN": ["CDG"],
        "CDG": ["MAN", "LGW"],
        "LC7": ["LGW", "ALC"],
        "STD": ["YYZ"],
        "YYZ": ["STD"],
        "SEA": ["LC7"],
        "JFK": ["SEA"]

    }

    def routable(origin, destination, visited_destinations):
        reachable = None  # Using True / False / None as a kind of trinary operator
        visited_destinations.add(origin)
        while reachable is None:
            if origin not in valid_routes:
                reachable = False
            else:
                for place in visited_destinations:
                    if place in valid_routes[origin]:
                        valid_routes[origin].remove(place)
                if destination in valid_routes[origin]:
                    reachable = True
                elif not valid_routes[origin]:
                    reachable = False
                else:
                    for place in valid_routes[origin]:
                        if routable(place, destination, visited_destinations):
                            reachable = True
        return reachable

    return routable(origin, destination, set())
