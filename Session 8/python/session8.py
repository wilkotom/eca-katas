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
        visited_destinations.add(origin)
        if origin not in valid_routes:
            return False
        else:
            for place in visited_destinations:
                if place in valid_routes[origin]:
                    valid_routes[origin].remove(place)
            if destination in valid_routes[origin]:
                return True
            elif not valid_routes[origin]:
                return False
            else:
                for place in valid_routes[origin]:
                    if routable(place, destination, visited_destinations):
                        return True
                return False

    return routable(origin, destination, set())
